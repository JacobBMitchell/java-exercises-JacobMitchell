
## High Level Description
Create a command line hotel that asks for capacity, check in guests, checkout guests, and show guests +- 5 from a given room.
I need to use variables, arrays, methods, if statements, and for/while loops, and use Scanners to get user input.

## Functional Requirements
Here you should list out requirements for my project from the provided assessment documentation:
* [ ] Initial inquiry about how many rooms.
* [ ] Create menu: Check in, out, view guests, exit
* [ ] Create methods for each menu option

###Check-in (checkIn(rooms))
Ask for room using scanner\
Check to see if room is available\
Ask for name and pair the two in the main array\
confirm check in

###Check-out (checkOut(rooms))
Ask for room using scanner\
check if room is occupied\
remove the occupant of the room\
confirm checkout

###View guests (viewGuests(rooms))
Scanner ask for room\
Check +5 from input if greater than rooms available start over from room 1(0)\
Check -5 from input, if less than decline from max.\
display rooms
.
###Exit
boolean an exit condition to be false and cancel while loop
