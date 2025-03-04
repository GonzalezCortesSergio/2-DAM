from fastapi import FastAPI
from routers import users
from fastapi.staticfiles import StaticFiles

app = FastAPI()


# Routers

app.include_router(users.router)
app.mount("/static", StaticFiles(directory="static"), name="static")

@app.get("/")
async def root():
    return "¡Hola FastAPI!"

@app.get("/url")
async def url():
    return {
        "url_curso": "https://mouredev.com/python"
    }