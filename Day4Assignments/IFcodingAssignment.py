import sys

class VendingMachine:
    water = 1.00        #Option 1
    cola = 1.50         #Option 2
    gatorade = 2.00     #Option 3

    #takes order input
    def order(self):
        order = input("Please enter your order:\n"
                      "1: Water $1.00\n"
                      "2: Cola $1.50\n"
                      "3: Gatorade $2.00\n")

        #checks if order number is within bounds
        if 3 >= int(order) >= 1:
            #calculates cost and prints change
            self.calculateCost(int(order))
        else:
            print("Invalid order")
            sys.exit()

    def calculateCost(self, order):

        #takes user input for cents
        quarters: int = int(input("Please enter your quarters: "))
        dimes: int = int(input("Please enter your dimes: "))
        nickles: int = int(input("Please enter your nickles: "))
        pennies: int = int(input("Please enter your pennies: "))

        #calculates total cents input by user
        total_cents = (quarters * 25) + (dimes * 10) + (nickles * 5) + pennies

        #finds dollar amount and remaining cents
        total_dollars = total_cents // 100
        remaining_cents = total_cents % 100

        #formats to dollar.cent rounded to 2 decimal places
        total: float = float(f"{total_dollars}.{remaining_cents:02d}")

        if order == 1:
            # Outputs change for order 1 if total is correct
            if total >= self.water:
                print(f"Change: ${(total - self.water):.2f}")
            else:
                print("Not enough money")
        elif order == 2:
            # Outputs change for order 2 if total is correct
            if total >= self.cola:
                print(f"Change: ${(total - self.cola):.2f}")
            else:
                print("Not enough money")
        elif order == 3:
            # Outputs change for order 3 if total is correct
            if total >= self.gatorade:
                print(f"Change: ${(total - self.gatorade):.2f}")
            else:
                print("Not enough money")
        else:
            print("Invalid order number")


#testing vending machine functions
test = VendingMachine()
test.order()

