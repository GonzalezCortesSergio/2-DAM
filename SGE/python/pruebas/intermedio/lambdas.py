### Lambdas ###

sum_two_values = lambda first_value, second_value: first_value + second_value
print(sum_two_values(1, 2))


multply_values = lambda first_value, second_value: first_value * second_value - 3

print(multply_values(2, 4))

def sum_three_values(value):
    return lambda first_value, second_value: first_value + second_value + value


def sum_value_and_lambda(value, sum_two_values):

    return value + sum_two_values


print(sum_value_and_lambda(5, sum_two_values(2, 4)))
print(sum_three_values(5)(2, 4))