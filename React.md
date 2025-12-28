# **What is React and why is it used?**
React is a JavaScript library used to build fast, interactive user interfaces. it uses a component-based architecture and a virtual DOM to efficiently update only the changed parts of the UI.

## **What is Virtual DOM?** 
Virtual DOM is a lightweight copy of the real DOM. React compares the previous and current Virtual DOM using diffing algorithm and updates only the changed nodes in the real DOM, improving performance.

**Is Virtual DOM faster than real DOM?**
No - minimizing DOM operations is faster.

## **What are Components?**
Components are reusable, independent UI blocks that return JSX. They help break the UI into smaller, manageable pieces.

## **What is JSX? Is it mandatory?**
JSX is a syntax extension that allows writing HTML like code inside JavaScript. It is not mandatory but improves readability and developer experience. 

**How does browser understand JSX?**
Babel converts JSX into React.createElement


# **Functional vs Class Component**

Functional components use hooks for state and lifecycle, while class components use this.state and lifecycle methods. Functional components are simpler and recommended approach in modern React.


## **What are Hooks? Why introduced?**
Hooks are functions that let us use state and lifecycle features in functional components. They were introduced to simplify code, avoid complex lifecycle methods, and improve logic reuse.  

# **Why hooks can't be use inside loops or conditions?**
Hooks must be called in the same order on every render, so they can't be used inside loops, conditions or nested functions.


## **useState - how does it work internally?**
useState returns a state variable and a setter function. When the setter is called, React schedules a re-render and updates the UI.

**Is useState synchronous?**
No, updates are asynchronous and batched. 

## **What is useRef?**
useRef creates a mutable object that persists across renders and does not trigger re-render when updated.

## **useEffect - when is it called?**
useEffect is used for side effects like API calls, subscriptions, and timers. It runs after render and depends on the dependency array. 
| Class Lifecycle      | Hook              |
| -------------------- | ----------------- |
| componentDidMount    | useEffect([], []) |
| componentDidUpdate   | useEffect([dep])  |
| componentWillUnmount | cleanup function  |

**What is cleanup function in useEffect?**
Cleanup functions prevent memory leaks by clearing subscriptions, timers, or listeners when component unmounts or dependencies change.

## **What is memoization in React?**
Memoization is an optimization technique that caches results or function references to prevent unnecessary recalculations or re-renders.

**When not to use memoization?**
When computation is cheap or re-renders are minimal, memoization adds unnecessary overhead and can hurt performance. 

## **useMemo vs useCallback?**
useMemo -> memoizes value  
userCallback -> memoizes function
useCallback is mainly used to prevent unnecessary child re-renders due to function recreation.


## **What is React.memo?**
React.memo is a higher-order component that prevents re-rendering of a functional component when its props do not change. 

export default React.memo(MyComponent);



## **What is prop drilling?**
Prop drilling is passing props through multiple intermediate components to reach a deeply nested component. 



# **What is Context API?**
Context API allows sharing global data like theme or user info without passing props manually at every level.

