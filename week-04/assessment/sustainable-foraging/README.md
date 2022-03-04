#Forager Catalog

##High Level
- Fix existing bugs
- Create and check tests
- Implement any unfinished features
- Add 'add a Forager'
- Create a report that displays the mass of each item on a day
- Create a report that displays the total value of each Category on one day
- Implement Spring Dependency (check)

##Requirements
- Detailed test methods
- New Test methods for both affirmative and negative inputs
- all types of assert correct and assert incorrect
- Methods that fill in gaps in the code
  - validations, and implementations that were overlooked
- New Methods to implement add a Forager in:
  - data layer
  - service layer
  -view layer 
- New methods to create each type of report using streams()
  - mass of item on a day
    - Find all the items on a day already saved, sum the mass
      print all items
  - total value of each category on a day
    - On a given day(file), group all of each category, sum the
    mass of each item, multiply by rate and add to total
- An xml file and ApplicationContext class to implement spring
     clean up App class, and create xml file.

##Plan
- Run Code initially, follow errors using debugger.(10 mins)
- Scan through code looking for any unimplemented features, implement those (1-2 hour)
- Scan through tests to make sure all test cases are met, fill in tests (1-3 hours)
- In the data layer provide an add Forager method (15-30 mins)
- Make sure nothing not accepted gets to the data layer in add Forager(30 mins)
- Implement it in the controller and view (30 mins)
- In Controller take existing data and display it in view to create
each type of report (30 mins - 1 hour)
- In the app class implement the Spring dependency (15-30 mins)

- Along the way in my tests I will implement new tests to chart my progress

###Methods
- Data layer:
  - addForager
- Service layer:
  - addForager
  - validateForager
- Controller:
  - addForager
  - createMassReport
  - createCostReport
- View:
  - addForagerDetails
  - displayMassReport
  - displayCostReport

##Important Notes
- Dates should be formatted using LocalDate
- Money should be dealt with using BigDecimal
- Files for Forages should be formatted yyyy-mm-dd.csv
- Contents of files are comma-delimited, prevent entering commas
- Forages contain a guid, forager's ID, the Item, and the mass

###Questions
- Am I understanding the requirements for the reports correctly?
- How many errors should I expect to find?
- What are the limits on what I should and shouldn't modify?
- Are there any major key features I am missing or overlooking?



