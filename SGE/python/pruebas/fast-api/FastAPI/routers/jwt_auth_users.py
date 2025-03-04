from fastapi import APIRouter, Depends, HTTPException, status
from pydantic import BaseModel
from fastapi.security import OAuth2PasswordBearer, OAuth2PasswordRequestForm
from passlib.context import CryptContext
from datetime import datetime, timedelta, timezone

ALGORITHM = "HS256"
ACCESS_TOKEN_DURATION = 1


app = APIRouter()
oauth2 = OAuth2PasswordBearer(tokenUrl="login")


crypt = CryptContext(schemes=["bcrypt"])


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
        "password": "$2a$12$oV4GyHSvvfJif/wYEF7jYeShizsa4yrKFHdOkjax5.IRKA4UPp332"
    },
    "mouredev2": {
        "username": "mouredev2",
        "full_name": "Brais Moure 2",
        "email": "braismoure2@mourede.com",
        "enabled": False,
        "password": "$2a$12$R2QKHobxTkrHZZE3KgVGheEXOb/JnKZwQN5zfOrPz3UgBTrWqdaxy"
    }
}

def search_user(username: str):
    if username in users_db:
        return UserDB(*users_db[username])
    
@app.post("/login")
async def login(form: OAuth2PasswordRequestForm = Depends()):

    user_db = users_db.get(form.username)

    if not user_db:
        raise HTTPException(
            status_code=status.HTTP_400_BAD_REQUEST,
            detail="El usuario no es correcto"
        )
    user = search_user(form.username)
    if not crypt.verify(form.password, user.password):
        raise HTTPException(
            status_code=status.HTTP_400_BAD_REQUEST, detail="La contraseña no es correcta"
        )
    
    expire = timezone.utc.fromutc(datetime.now()) + timedelta(minutes=ACCESS_TOKEN_DURATION)
    
    access_token = {
        "sub": user.username, 
        "exp": expire,
        }
    
    return {
        "access_token": access_token,
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