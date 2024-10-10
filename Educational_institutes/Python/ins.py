#Name : Devarsh Naik
#Rollno: 10
#start 24/07/2024
#description:: the code below takes a csv file as a input and converts it into an array of objects 

import csv

# Define the Edu_Institutes class
class Edu_Institutes:
    def __init__(self, sno, InstituteName):
        self.sno = sno
        self.InstituteName = InstituteName

# Define the InstitutesofNatImp class that inherits from Edu_Institutes
class InstitutesofNatImp(Edu_Institutes):
    def __init__(self, sno, InstituteName, City, State, Act_name, Dept):
        super().__init__(sno, InstituteName)
        self.City = City
        self.State = State
        self.Act_name = Act_name if Act_name else "undefined"
        self.Dept = Dept if Dept else "undefined"

    def __repr__(self):
        return (f"InstitutesofNatImp(sno={self.sno}, InstituteName='{self.InstituteName}', "
                f"City='{self.City}', State='{self.State}', Act_name='{self.Act_name}', Dept='{self.Dept}')")

    def InstituteInfo(self):
        print("Sno:", self.sno)
        print("Name of the Institute:", self.InstituteName)
        print("City:", self.City)
        print("State:", self.State)
        print("Name of Act:", self.Act_name)
        print("Department:", self.Dept)

# Define the UniversitiesofIndia class that inherits from InstitutesofNatImp
class UniversitiesofIndia(InstitutesofNatImp):
    def __init__(self, sno, InstituteName, City, State, Act_name, Dept, UniName, Year):
        super().__init__(sno, InstituteName, City, State, Act_name, Dept)
        self.UniName = UniName
        self.Year = Year

    def __repr__(self):
        return (f"UniversitiesofIndia(sno={self.sno}, InstituteName='{self.InstituteName}', "
                f"City='{self.City}', State='{self.State}', Act_name='{self.Act_name}', Dept='{self.Dept}', "
                f"UniName='{self.UniName}', Year={self.Year})")

    def InstituteInfo(self):
        print("Sno:", self.sno)
        print("Name of the University:", self.UniName)
        print("City:", self.City)
        print("State:", self.State)
        print("Year:", self.Year)

# Main function to create an array of InstitutesofNatImp objects from a CSV file
def main():
    # Path to the CSV file
    csv_file_path = 'test.csv'

    # List to hold the Institute objects
    institutes_list = []

    # Open and read the CSV file
    try:
        with open(csv_file_path, mode='r', newline='', encoding='utf-8') as file:
            reader = csv.DictReader(file)  # Read CSV into a dictionary
            
            # Ensure we have the expected columns
            required_columns = {'sno', 'InstituteName', 'City', 'State', 'Act_name', 'Dept', 'UniName', 'Year'}
            if not required_columns.issubset(reader.fieldnames):
                raise ValueError(f"CSV file is missing required columns. Found columns: {reader.fieldnames}")

            # Iterate over each row in the CSV file
            for row in reader:
                sno = int(row['sno'])
                InstituteName = row['InstituteName']
                City = row['City']
                State = row['State']
                Act_name = row['Act_name']
                Dept = row['Dept']
                UniName = row['UniName'] if 'UniName' in row else "undefined"  # Handle potential missing UniName
                Year = int(row['Year']) if 'Year' in row and row['Year'].isdigit() else 0  # Handle potential missing or invalid Year

                # Create an instance of UniversitiesofIndia (as an example)
                institute = UniversitiesofIndia(sno, InstituteName, City, State, Act_name, Dept, UniName, Year)

                # Append the instance to the list
                institutes_list.append(institute)

        # Print out the list of institutes to verify
        for institute in institutes_list:
            print(institute)

    except FileNotFoundError:
        print(f"File not found: {csv_file_path}")
    except ValueError as ve:
        print(f"ValueError: {ve}")
    except Exception as e:
        print(f"An unexpected error occurred: {e}")

# Entry point of the script
if __name__ == '__main__':
    main()
