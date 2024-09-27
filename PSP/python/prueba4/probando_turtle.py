from turtle import *

res = None

t = Turtle()

t.color("brown")

for i in range(4):
    t.forward(50)
    t.left(90)


t.penup()
t.left(90)
t.forward(50)
t.pendown()

t.right(30)
t.forward(50)
t.right(120)
t.forward(50)

mainloop()