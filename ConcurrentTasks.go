package main

import (
	"fmt"
	"time"
)

// Task 1: Compute squares of numbers from 1 to 5
func computeSquares(ch chan string) {
	fmt.Println("[Goroutine 1] Starting: Calculating Squares...")
	for i := 1; i <= 5; i++ {
		time.Sleep(50 * time.Millisecond) // Simulating independent processing time
		ch <- fmt.Sprintf("Square of %d = %d", i, i*i)
	}
	fmt.Println("[Goroutine 1] Completed.")
}

// Task 2: Compute cubes of numbers from 1 to 5
func computeCubes(ch chan string) {
	fmt.Println("[Goroutine 2] Starting: Calculating Cubes...")
	for i := 1; i <= 5; i++ {
		time.Sleep(40 * time.Millisecond)
		ch <- fmt.Sprintf("Cube of %d = %d", i, i*i*i)
	}
	fmt.Println("[Goroutine 2] Completed.")
}

// Task 3: Compute first 5 Fibonacci numbers
func computeFibonacci(ch chan string) {
	fmt.Println("[Goroutine 3] Starting: Calculating Fibonacci Sequence...")
	a, b := 0, 1
	for i := 1; i <= 5; i++ {
		time.Sleep(60 * time.Millisecond)
		ch <- fmt.Sprintf("Fibonacci term %d = %d", i, a)
		next := a + b
		a = b
		b = next
	}
	fmt.Println("[Goroutine 3] Completed.")
}

func main() {
	fmt.Println("=== Main Program Started: Launching Goroutines ===")

	// 2. Create a channel of type string to collect results from all goroutines
	resultsChannel := make(chan string)

	// 1. Launch at least three goroutines concurrently using the 'go' keyword
	go computeSquares(resultsChannel)
	go computeCubes(resultsChannel)
	go computeFibonacci(resultsChannel)

	// Total messages expected = 3 goroutines * 5 values each = 15 messages
	totalMessages := 15

	fmt.Println("\n--- Collecting Results from Channel in Main ---")
	for i := 0; i < totalMessages; i++ {
		// Read and print results as they arrive from the channel
		result := <-resultsChannel
		fmt.Println("Received ->", result)
	}

	fmt.Println("\n=== Main Program Finished ===")
}
