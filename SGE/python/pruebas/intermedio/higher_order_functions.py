### Higher Order Functions ###

from functools import reduce


def sum_one(value):
    return value + 1

def sum_five(value):

    return value + 5

def sum_two_values_and_add_value(first_value, second_value, f_sum):
    return f_sum(first_value + second_value)

print(sum_two_values_and_add_value(5, 2, sum_one))

print(sum_two_values_and_add_value(5, 2, sum_five))


### Closures ###

def sum_ten(original_value):
    def add(value):
        return value + 10 + original_value
    
    return add
    
add_closure = sum_ten(5)
print(add_closure(5))

print(sum_ten(5)(5))


### Built-in Higher order functions ###

numbers = [2, 5, 10, 21]

numbers_por_dos = list(map(lambda number: number * 2, numbers))

print(numbers_por_dos)


numbers_greater_than_10 = list(filter(lambda number: number >= 10, numbers))

print(numbers_greater_than_10)


print(reduce(lambda first_value, second_value: first_value + second_value, numbers))