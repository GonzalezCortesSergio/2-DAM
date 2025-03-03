from fastapi import FastAPI
from pydantic import BaseModel
from http import HTTPStatus



app = FastAPI()

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

@app.get("/usersjson")
async def users_json():

    return users

# Path parameter

@app.get("/user/{id}")
async def user_details(id: int):
    try:
        return list(filter(lambda usuario: usuario.id == id, users))[0]
    except:
        return {
            "error": "Entity not found"
        }
    

# Query parameter

@app.get("/user")
async def user_query(id: int):
    try:
        return list(filter(lambda usuario: usuario.id == id, users))[0]
    except:
        return {
            "error": "Entity not found"
        }
