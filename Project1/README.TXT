PROJECT TITLE: Simulating a Farmer's Market
PURPOSE OF PROJECT: CS150 Project 1
VERSION: 1.0
HOW TO START THIS PROJECT: Run main() method from MarketSimulation class.
AUTHORS: Nakul Talwar
USER INSTRUCTIONS: 
1)The main() method in MarketSimulation will bring up an interactive text interface.
2)Parameters for number of stalls can be changed using the interface.
3)While using the interface, simply type the required number and hit Enter.
4)To see the complete data that is output by the simulation, the option for Unlimited Buffering MUST be enabled on the BlueJ terminal.

NOTE: If any other constraints need to be changed they will need to be changed manually.

For changing Gaussian arrival times in the market-
Change parameters for ArrivalTimeGenerator in the MarketSimulation constructor method.

For changing Gaussian processing times for each stall-
Change parameters for StallTimeGenerator in the respective Stall child class constructor methods.

For changing Gaussian percentage needs for customers-
Change parameters for the respective need-associated GaussianGenerator object in the Customer constructor method.