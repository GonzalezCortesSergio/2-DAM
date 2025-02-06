### Dates ###

from datetime import datetime
from datetime import time

def print_date(date):
    
    print(date.day)
    print(date.month)
    print(date.year)
    print(date.hour)
    print(date.minute)
    print(date.second)

now = datetime.now()

print_date(now)



timestamp = now.timestamp()

print(timestamp)

year_2023 = datetime(2023, 1, 1)

print_date(year_2023)
