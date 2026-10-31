package main

import (
	"errors"
	"fmt"
	"math"
	"strings"
)

// (1) Divide function returning an error on division by zero
func Divide(a, b float64) (float64, error) {
	if b == 0 {
		return 0, fmt.Errorf("division error: cannot divide %.2f by zero", a)
	}
	return a / b, nil
}

// (1) SquareRoot function returning an error on negative input
func SquareRoot(val float64) (float64, error) {
	if val < 0 {
		return 0, fmt.Errorf("math error: cannot calculate square root of negative number %.2f", val)
	}
	return math.Sqrt(val), nil
}

// (1) ProcessInput function returning an error on empty string
func ProcessInput(input string) (string, error) {
	trimmed := strings.TrimSpace(input)
	if trimmed == "" {
		return "", errors.New("input error: input string cannot be empty or whitespace only")
	}
	return fmt.Sprintf("Processed: %s", trimmed), nil
}

func main() {
	fmt.Println("=== Error Handling & Unit Testing Demo ===")
	
	// Example valid & invalid executions
	if res, err := Divide(10, 2); err == nil {
		fmt.Println("Result:", res)
	}
	
	if _, err := SquareRoot(-9); err != nil {
		fmt.Println("Caught:", err)
	}
}
