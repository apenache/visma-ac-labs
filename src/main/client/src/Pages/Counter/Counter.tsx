import React, {useEffect, useState} from "react";
import Button from '@mui/material/Button'
import Checkbox from '@mui/material/Checkbox';

export function Counter() {
    const [count, setCount] = useState<number>(0);
    const [isHighlighted, setIsHighlighted] = useState<boolean>(false);

    // let isHighlighted: boolean = false;
    // function setIsHighlighted(value: boolean) {
    //     isHighlighted = value;
    // }

    useEffect(() => {
        console.log(`Changed highlighted state to ${isHighlighted}`);
    }, [isHighlighted])

    useEffect(() => {
        console.log(`Changed count state to ${count}`);
    }, [count])

    console.log('I am outside');

    useEffect(() => {
        console.log('Rendered components')

        let array = [1, 2, 3];
        array.forEach((value) => console.log(value));
        function doOnEachElement(array: number[], callback: (element: number) => void) {

            for (let i = 0; i < array.length; i++) {
                callback(array[i]);
            }
        }
        doOnEachElement(array, (value) => console.log(value));
    }, [])

    return (
        <div style={{
            margin: 10,
            padding: 20,
            width: 'fit-content',
            display: 'flex',
            gap: '5px',
            border: '5px solid',
            borderColor: isHighlighted ? "black" : 'red'}}>
            Count: {count}
            <Button variant="contained" onClick={() => setCount(count + 1)}>+</Button>
            <Button variant="contained" onClick={() => setCount(count - 1)}>-</Button>

            <Checkbox checked={isHighlighted} onChange={() => {
                setIsHighlighted(!isHighlighted);
                console.log('new h: ', isHighlighted)
            }}/>
        </div>
    )
}