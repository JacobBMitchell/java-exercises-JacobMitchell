#Don't Wreck My House

##High Level
- View existing reservations for a host.
- Create a reservation for a guest with a host.
- Edit existing reservation
- Cancel **FUTURE** reservations

##Requirements
- Data layer that has access to files
  - Reservations
  - Hosts/Locations
  - Guests
- Domain layer that qualifies input from the user and prevents 
unwanted or 'illegal' actions from being performed
  - Guest Service
  - Host Service
  - Reservation Service that takes in Guests and Hosts
- Controller that asks for information from the service layers 
and provides that information to the view layer
  - View reservations per host
  - create reservations with guest and host
  - edit reservations
  - cancel future reservations
- View Layer that takes information provided and organized by 
the controller and displays it to the user in a nice and well
formatted way
  - Println
  - header
  - getDate
  - getHost/guest
  - getLocation
  - make reservation
  - display information
- Models that organize that data into useful bins to operate
on and store data
  - Reservations
  - Guests
  - Host
    - location
- App class that ultimately merges all these things into one 
using spring 
  - in resources -> xml file that holds information

##Plan
- Start with basic models to use throughout the program (20 mins)
- Create Guest data repository (40 mins)
- Test Guest data repo (along the way) (30 mins)
- Create and test Host+Location Repo (45 mins)
- Test host repo (35 mins)
- Create Reservation repo (1 1/2 hours)
- Test Reservation repo (1 hour)

- Create a domain layer for guests (45 mins)
- Create tests on the domain layer (1 hour)
- Create a domain layer for Hosts (45 mins)
- Create tests on the host services(1 hour)
- Create a service for Reservations (90 mins)
- Test Reservation services (2 hours)

- Work on App Controller and view concurrently
  - in App create the spring dependency (35 mins)
  - in Controller create run method (10 mins)
  - create View by host method (20 mins)
  - create necessary view method requirements for input and output (40 mins)
  - create create reservation (15 mins)
  - make the inputs and outputs in view (25 mins)
  - make the update reservation in controller (30 mins)
  - the methods required in view (10 mins)
  - delete in controller (20 mins)
  - delete in view (5 mins)

- Late stage bug fixing and formatting (2 hours)

##Important Notes
- new reservations should only be able to be made after today
- cancellations must also be in the future
- Money should be dealt with in Big Decimal
- Time should be formatted and use LocalDate
- This is viewed by an administrator
- Hosts can only have one location
- Rates change over weekends
- guests.csv, host.csv
- reservations have {host-id}.csv so dependent on the host 
the reservations are organized

##Questions
- What is the rate on weekdays vs weekends?
- Are the hosts limited to what's provided or when making a reservation
will I need to add a new host?
