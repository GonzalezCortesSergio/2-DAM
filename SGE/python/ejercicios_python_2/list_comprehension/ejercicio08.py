def par_impar():

    numbers = range(20)

    par_impar = list(map(lambda numero: "par" if numero % 2 == 0 else "impar", numbers))

    return par_impar

print(par_impar())