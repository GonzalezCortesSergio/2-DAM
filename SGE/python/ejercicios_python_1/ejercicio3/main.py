
def transformar_cadenas(str1: str, str2: str):

    str1_list = list(str1)
    str2_list = list(str2)
    for char in str2:
        if(char in str1_list):
            str1_list.remove(char)

    for char in str1:

        if(char in str2_list):
            str2_list.remove(char)

    out1 = "".join(str1_list)
    out2 = "".join(str2_list)


    return out1, out2