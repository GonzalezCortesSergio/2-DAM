### Regular Expressions ###

import re

my_string = "esta es la lección número 7, Lección llamada: Expresiones regulares"
my_other_string = "Esta no es la lección número 6: Manejo de ficheros"

match = re.match("Esta es la lección", my_string, re.I)

print(match)
span = match.span()
print(span)

print(match)

start, end = span

print(my_string[start:end])


match = re.match("Esta no es la lección", my_other_string)
if match != None:
    print(match)
    start, end = match.span()
    print(my_other_string[start:end])



search = re.search("lección", my_string, re.I)
print(search)


findall = re.findall("lección", my_string, re.I)
print(findall)


split = re.split(":", my_string)
print(split)

print(re.sub("lección|Lección", "LECCIÓN", my_string))
print(re.sub("Expresiones regulares", "RegEx", my_string))

# Patterns

pattern = r'[0-9]'

print(re.findall(pattern, my_string))

print(re.search(pattern, my_string))