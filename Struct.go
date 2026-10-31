package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

// 1. Define a Go struct named Person
type Person struct {
	Name   string
	Age    int
	Job    string
	Salary float64
}

// 2. Method with a pointer receiver to read data into the struct from user input
func (p *Person) ReadData(reader *bufio.Reader) {
	fmt.Print("Enter Name: ")
	nameInput, _ := reader.ReadString('\n')
	p.Name = strings.TrimSpace(nameInput)

	fmt.Print("Enter Age: ")
	ageInput, _ := reader.ReadString('\n')
	age, err := strconv.Atoi(strings.TrimSpace(ageInput))
	if err == nil {
		p.Age = age
	}

	fmt.Print("Enter Job: ")
	jobInput, _ := reader.ReadString('\n')
	p.Job = strings.TrimSpace(jobInput)

	fmt.Print("Enter Salary: ")
	salaryInput, _ := reader.ReadString('\n')
	salary, err := strconv.ParseFloat(strings.TrimSpace(salaryInput), 64)
	if err == nil {
		p.Salary = salary
	}
}

// Method with a value receiver to print all fields in a formatted manner
func (p Person) PrintData() {
	fmt.Println("----------------------------------------")
	fmt.Printf(" Name   : %s\n", p.Name)
	fmt.Printf(" Age    : %d\n", p.Age)
	fmt.Printf(" Job    : %s\n", p.Job)
	fmt.Printf(" Salary : $%.2f\n", p.Salary)
	fmt.Println("----------------------------------------")
}

func main() {
	reader := bufio.NewReader(os.Stdin)

	// 3. Create at least two Person objects and call both methods on each
	fmt.Println("=== Enter details for Person 1 ===")
	var p1 Person
	p1.ReadData(reader)

	fmt.Println("\n=== Enter details for Person 2 ===")
	var p2 Person
	p2.ReadData(reader)

	fmt.Println("\n========================================")
	fmt.Println("       DISPLAYING PERSON RECORDS        ")
	fmt.Println("========================================")
	
	fmt.Println("\nRecord 1:")
	p1.PrintData()

	fmt.Println("\nRecord 2:")
	p2.PrintData()
}
