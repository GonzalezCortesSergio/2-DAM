### Dates ###

from datetime import datetime
from datetime import time
from datetime import date

def print_date(date):
    
    print(date.day)
    print(date.month)
    print(date.year)
    print(date.hour)
    print(date.minute)
    print(date.second)
    print(date.timestamp())

now = datetime.now()

print_date(now)


year_2023 = datetime(2023, 1, 1, 0)

print_date(year_2023)




current_time = time(8, 23, 46)

print(current_time.hour)
print(current_time.minute)
print(current_time.second)


current_date = date(2025, 4, 12)

current_date = current_date.today()

print(current_date.day)
print(current_date.month)
print(current_date.year)

