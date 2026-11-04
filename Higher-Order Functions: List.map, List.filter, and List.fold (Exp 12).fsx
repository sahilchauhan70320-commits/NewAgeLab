open System
[<EntryPoint>]
let main argv =
    let list1 = [1; 2; 3; 4; 5]
    let list2 = [10; 15; 20; 25; 30]
    printfn "=== Initial Lists ==="
    printfn "List 1: %A" list1
    printfn "List 2: %A" list2
    printfn ""
    let mapped1 = List.map (fun x -> x * x) list1
    let mapped2 = List.map (fun x -> x * x) list2
    printfn "--- 1. List.map (Squaring elements) ---"
    printfn "List 1 squared: %A" mapped1
    printfn "List 2 squared: %A" mapped2
    printfn ""
    let filtered1 = List.filter (fun x -> x % 2 = 0) list1
    let filtered2 = List.filter (fun x -> x % 2 = 0) list2
    printfn "--- 2. List.filter (Retaining even numbers) ---"
    printfn "List 1 evens: %A" filtered1
    printfn "List 2 evens: %A" filtered2
    printfn ""
    let folded1 = List.fold (fun acc x -> acc + x) 0 list1
    let folded2 = List.fold (fun acc x -> acc + x) 0 list2
    printfn "--- 3. List.fold (Summing elements) ---"
    printfn "List 1 sum: %d" folded1
    printfn "List 2 sum: %d" folded2

    0
