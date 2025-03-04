from fastapi import APIRouter
from pydantic import BaseModel
from fastapi import HTTPException
from http import HTTPStatus


router = APIRouter(prefix="/users")

# Entidad User

class User(BaseModel):

    id: int
    name: str
    surname: str
    url: str
    age: int

users = [
    User(id= 1,name="Sergio", surname="González Cortés", url="http://web.com", age=19),
    User(id=2, name="Sergio", surname="González Cortés", url="http://web.com", age=19),
    User(id=3, name="Sergio", surname="González Cortés", url="http://web.com", age=19),
    User(id=4, name="Sergio", surname="González Cortés", url="http://web.com", age=19),
    User(id=5, name="Sergio", surname="González Cortés", url="http://web.com", age=19)
]

@router.get("/")
async def users_json():

    return users

# Path parameter

@router.get("/{id}", response_model=User)
async def user_details(id: int):
    try:
        return search_user(id)
    except:
        raise HTTPException(404, "Entity not found")
    

# Query parameter

@router.get("/", response_model=User)
async def user_query(id: int):
    try:
        return search_user(id)
    except:
        raise HTTPException(404, "Entity not found")
    

@router.post("/", status_code=HTTPStatus.CREATED, response_model=User)
async def add_user(user: User):

    users.append(user)

    return user


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


@router.delete("/{id}", status_code=204)
async def delete_user(id: int):
    try:
        usuario = search_user(id)
        users.remove(usuario)

    except:
        pass
    


def search_user(id: int):

    return list(filter(lambda usuario: usuario.id == id, users))[0]

