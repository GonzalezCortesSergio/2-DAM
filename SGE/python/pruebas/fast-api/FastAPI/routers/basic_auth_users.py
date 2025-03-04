from fastapi import FastAPI, Depends, HTTPException, status
from pydantic import BaseModel
from fastapi.security import OAuth2PasswordBearer, OAuth2PasswordRequestForm


app = FastAPI()
oauth2 = OAuth2PasswordBearer(tokenUrl="login")


class User(BaseModel):
    
    username: str
    full_name: str
    email: str
    enabled: bool

class UserDB(User) :

    password: str


users_db = {
    "mouredev": {
        "username": "mouredev",
        "full_name": "Brais Moure",
        "email": "braismoure@mourede.com",
        "enabled": True,
        "password": "123456"
    },
    "mouredev2": {
        "username": "mouredev2",
        "full_name": "Brais Moure 2",
        "email": "braismoure2@mourede.com",
        "enabled": False,
        "password": "654321"
    }
}

def search_user(username: str):
    if username in users_db:
        return UserDB(users_db[username])
    
@app.post("/login")
async def login(form: OAuth2PasswordRequestForm = Depends()):

    user_db = users_db.get(form.username)

    if not user_db:
        raise HTTPException(
            status_code=status.HTTP_400_BAD_REQUEST,
            detail="El usuario no es correcto"
        )
    user = search_user(form.username)
    if form.password != user.password:
        raise HTTPException(
            status_code=status.HTTP_400_BAD_REQUEST, detail="La contraseña no es correcta"
        )
    
    return {
        "access_token": user.username,
        "token_type": "bearer"
    }

async def current_user(token: str = Depends(oauth2)):
    user = search_user(token)

    if not user:
        raise HTTPException(
            status_code=status.HTTP_401_UNAUTHORIZED, detail="Credenciales de autenticación no válidas",
            headers={"WWW-Authenticate": "Bearer"}
        )




@app.get("/users/me")
async def me(user: User = Depends(current_user)):
    return user