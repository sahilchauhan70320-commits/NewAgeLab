package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	// 1. Variable declaration and Data Types
	reader := bufio.NewReader(os.Stdin)
	fmt.Print("Enter your name: ")
	name, _ := reader.ReadString('\n')
	name = strings.TrimSpace(name)

	// 2. Input-driven numeric computation
	fmt.Print("Enter your age: ")
	ageInput, _ := reader.ReadString('\n')
	ageInput = strings.TrimSpace(ageInput)

	// Convert string input to integer with validation
	age, err := strconv.Atoi(ageInput)
	if err != nil || age < 0 {
		fmt.Println("Error: Invalid age entered.")
		return
	}

	// 3. Control Structures (if / else)
	fmt.Printf("\nHello, %s!\n", name)
	if age >= 18 {
		fmt.Println("Status: You are an adult (eligible to vote).")
	} else {
		fmt.Println("Status: You are a minor.")
	}

	// Example loop structure
	fmt.Println("\nCounting down to launch:")
	for i := 3; i > 0; i-- {
		fmt.Println(i)
	}
	fmt.Println("Go!")
}
