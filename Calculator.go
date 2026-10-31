package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	reader := bufio.NewReader(os.Stdin)

	for {
		fmt.Println("\n==============================")
		fmt.Println("       SIMPLE CALCULATOR      ")
		fmt.Println("==============================")
		fmt.Println("1. Integer Arithmetic")
		fmt.Println("2. Floating-Point Arithmetic")
		fmt.Println("3. Exit")
		fmt.Print("Choose an option (1-3): ")

		choiceStr := readInput(reader)
		choice, err := strconv.Atoi(choiceStr)
		if err != nil || choice < 1 || choice > 3 {
			fmt.Println("[Error] Invalid choice. Please enter a number between 1 and 3.")
			continue
		}

		if choice == 3 {
			fmt.Println("Exiting calculator. Goodbye!")
			break
		}

		// Handle Integer Arithmetic
		if choice == 1 {
			fmt.Println("\n--- Integer Mode ---")
			num1 := getValidInt(reader, "Enter first integer: ")
			num2 := getValidInt(reader, "Enter second integer: ")

			fmt.Println("\nSelect Operation:")
			fmt.Println("  + : Addition")
			fmt.Println("  - : Subtraction")
			fmt.Println("  * : Multiplication")
			fmt.Print("Enter operator (+, -, *): ")
			op := strings.TrimSpace(readInput(reader))

			switch op {
			case "+":
				fmt.Printf("Result: %d + %d = %d\n", num1, num2, num1+num2)
			case "-":
				fmt.Printf("Result: %d - %d = %d\n", num1, num2, num1-num2)
			case "*":
				fmt.Printf("Result: %d * %d = %d\n", num1, num2, num1*num2)
			default:
				fmt.Println("[Error] Invalid operator selected.")
			}
		}

		// Handle Floating-Point Arithmetic
		if choice == 2 {
			fmt.Println("\n--- Floating-Point Mode ---")
			num1 := getValidFloat(reader, "Enter first float value: ")
			num2 := getValidFloat(reader, "Enter second float value: ")

			fmt.Println("\nSelect Operation:")
			fmt.Println("  + : Addition")
			fmt.Println("  - : Subtraction")
			fmt.Println("  * : Multiplication")
			fmt.Print("Enter operator (+, -, *): ")
			op := strings.TrimSpace(readInput(reader))

			switch op {
			case "+":
				fmt.Printf("Result: %.2f + %.2f = %.2f\n", num1, num2, num1+num2)
			case "-":
				fmt.Printf("Result: %.2f - %.2f = %.2f\n", num1, num2, num1-num2)
			case "*":
				fmt.Printf("Result: %.2f * %.2f = %.2f\n", num1, num2, num1*num2)
			default:
				fmt.Println("[Error] Invalid operator selected.")
			}
		}
	}
}

// Helper function to read stripped string input
func readInput(reader *bufio.Reader) string {
	input, _ := reader.ReadString('\n')
	return strings.TrimSpace(input)
}

// Loop and if-statement validation for integer input
func getValidInt(reader *bufio.Reader, prompt string) int {
	for {
		fmt.Print(prompt)
		valStr := readInput(reader)
		val, err := strconv.Atoi(valStr)
		if err != nil {
			fmt.Println("[Error] Non-numeric or invalid integer detected. Please try again.")
			continue
		}
		return val
	}
}

// Loop and if-statement validation for floating-point input
func getValidFloat(reader *bufio.Reader, prompt string) float64 {
	for {
		fmt.Print(prompt)
		valStr := readInput(reader)
		val, err := strconv.ParseFloat(valStr, 64)
		if err != nil {
			fmt.Println("[Error] Non-numeric or invalid floating-point value detected. Please try again.")
			continue
		}
		return val
	}
}
