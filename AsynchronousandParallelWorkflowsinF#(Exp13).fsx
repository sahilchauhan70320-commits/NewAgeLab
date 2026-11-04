open System

// Define asynchronous tasks simulating I/O-bound or compute-intensive work
let simulateTask (name: string) (delayMs: int) =
    async {
        // Log start time to demonstrate non-sequential execution
        printfn "[%s] Started at %s" name (DateTime.Now.ToString("HH:mm:ss.fff"))
        
        // Simulate an asynchronous delay (e.g., waiting for an API or database query)
        do! Async.Sleep delayMs
        
        // Log completion time
        printfn "[%s] Completed at %s (Delay was %d ms)" name (DateTime.Now.ToString("HH:mm:ss.fff"))
        
        // Return a result string
        return sprintf "Payload from %s" name
    }

[<EntryPoint>]
let main argv =
    // Wrap the workflow in an async block and execute it synchronously at the entry point
    async {
        printfn "=== Starting Concurrent Execution ==="
        let overallStartTime = DateTime.Now

        // 1. Define at least three tasks with different durations
        let task1 = simulateTask "Task-A (Slow)" 1200
        let task2 = simulateTask "Task-B (Fast)" 300
        let task3 = simulateTask "Task-C (Medium)" 700

        // 2. Run tasks concurrently using Async.Parallel
        // Notice the non-sequential order: Task-B finishes first, then Task-C, then Task-A.
        let! results = [| task1; task2; task3 |] |> Async.Parallel

        let overallDuration = (DateTime.Now - overallStartTime).TotalMilliseconds
        printfn "\n=== All Tasks Finished ==="
        printfn "Total execution time: %.0f ms (significantly less than sum of delays)\n" overallDuration

        // 3. Collect and print all results
        printfn "Collected Results:"
        results 
        |> Array.iter (fun res -> printfn " - %s" res)

        return 0
    } 
    |> Async.RunSynchronously
