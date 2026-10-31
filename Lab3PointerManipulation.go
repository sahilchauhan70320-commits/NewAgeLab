package main

import "fmt"

// Define a sample struct for part (3)
type Student struct {
	Name  string
	Grade float64
}

// Function for part (2): Accepts a pointer parameter to modify the original variable
func updateScore(score *int) {
	fmt.Printf("[Inside Function] Address received: %p\n", score)
	fmt.Printf("[Inside Function] Value before modification: %d\n", *score)
	
	// Modify the value at the memory address
	*score = 95
	
	fmt.Printf("[Inside Function] Value after modification: %d\n", *score)
}

func main() {
	fmt.Println("=== 1. Referencing and Dereferencing ===")
	// (1) Declare a variable, print its address using & and access its value using *
	var originalVar int = 42
	var ptr *int = &originalVar // ptr holds the memory address of originalVar

	fmt.Printf("Value of originalVar: %d\n", originalVar)
	fmt.Printf("Address of originalVar (&originalVar): %p\n", &originalVar)
	fmt.Printf("Value of pointer ptr (the address it holds): %p\n", ptr)
	fmt.Printf("Accessing value using dereference (*ptr): %d\n", *ptr)

	fmt.Println("\n=== 2. Pass-by-Reference Function ===")
	// (2) Write a function that accepts a pointer parameter and modifies the original variable
	myScore := 75
	fmt.Printf("Before function call - myScore: %d (Address: %p)\n", myScore, &myScore)
	
	// Pass the address of myScore using &
	updateScore(&myScore)
	
	fmt.Printf("After function call - myScore: %d\n", myScore)

	fmt.Println("\n=== 3. Struct Allocation Using new() ===")
	// (3) Allocate a struct using new() and access/modify its fields through the pointer
	// new(Student) allocates memory for a Student struct, zeroes its fields, and returns a pointer (*Student)
	studentPtr := new(Student)

	fmt.Printf("Pointer returned by new(): %p\n", studentPtr)
	fmt.Printf("Initial values (zero-allocated): Name = '%s', Grade = %.2f\n", studentPtr.Name, studentPtr.Grade)

	// Modify fields through the pointer (Go automatically dereferences struct pointers)
	studentPtr.Name = "Alice"
	studentPtr.Grade = 88.5

	fmt.Printf("Modified values via pointer: Name = '%s', Grade = %.2f\n", studentPtr.Name, studentPtr.Grade)
}
