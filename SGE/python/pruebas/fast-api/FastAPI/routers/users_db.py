from fastapi import APIRouter
from fastapi import HTTPException, status
from http import HTTPStatus
from db.models.user import User
from db.client import db_client
from db.schemas.user import user_schema


router = APIRouter(prefix="/users",
                   tags=["users"],
                   responses={404: {"message": "No encontrado"}})


db_user = db_client.local.users

# Entidad User

users = []

@router.get("/")
async def users_json():

    return db_user.find()

# Path parameter

@router.get("/{email}", response_model=User)
async def user_details(email: str):
    try:
        return search_user_by_email(email)
    except:
        raise HTTPException(404, "Entity not found")
    

# Query parameter

@router.get("/", response_model=User)
async def user_query(email: str):
    try:
        return search_user_by_email(email)
    except:
        raise HTTPException(404, "Entity not found")
    

@router.post("/", status_code=HTTPStatus.CREATED, response_model=User)
async def add_user(user: User):

    if type(search_user_by_email(user.email)) == User:
        raise HTTPException(status.HTTP_400_BAD_REQUEST, "El usuario ya existe")
    
    user_dict = dict(user)
    del user_dict["id"]
    
    id = db_user.insert_one(user_dict).inserted_id

    new_user = user_schema(db_user.find_one({"_id": id}))

    return User(**new_user)


@router.put("/{id}", response_model=User)
async def edit_user(user: User, id: int):
    
    found = False

    for index, usuario in enumerate(users):
        if usuario.id == id:
            users[index] = user
            found = True

    if not found:
        raise HTTPException(HTTPStatus.NOT_FOUND, detail="No se ha encontrado el usuario")

    return user 


@router.delete("/{email}", status_code=204)
async def delete_user(email: str):
    try:
        usuario = user_schema(search_user_by_email(id))
        users.remove(usuario)

    except:
        pass
    


def search_user_by_email(email: str):

    try:
        user = user_schema(db_user.find_one({"email": email}))

        return User(**user)

    except:
        raise HTTPException(status.HTTP_404_NOT_FOUND, "Usuario no encontrado")