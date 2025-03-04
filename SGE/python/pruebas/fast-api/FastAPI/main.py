from fastapi import FastAPI
from routers import jwt_auth_users, users_db
from fastapi.staticfiles import StaticFiles

app = FastAPI()


# Routers

app.include_router(users_db.router)
app.include_router(jwt_auth_users.app)
app.mount("/static", StaticFiles(directory="static"), name="static")

@app.get("/")
async def root():
    return "¡Hola FastAPI!"

@app.get("/url")
async def url():
    return {
        "url_curso": "https://mouredev.com/python"
    }