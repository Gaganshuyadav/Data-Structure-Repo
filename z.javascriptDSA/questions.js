



// let num1A = [ 3, 2, 1];
// let num2A= [ 1, 2, 3];

// let num1 = ""; 
// let num2 = "";

// for(let i=0; i<num1A.length; i++){
//     num1 += num1A[i];
// }

// for(let i=0; i<num2A.length; i++){
//     num2 += num2A[i];
// }

// let ans = Math.abs(num2 - num1); 
// console.log(ans)
// let ansA = new Array(ans.toString().length).fill(0); 

// for(let i=0; i<ans.toString().length; i++){
//     console.log(ans.toString().charAt(i) +"   ");
// }

 
// let m1 = [1, 3, 4, 5];
// let m2 = [2, 4, 6, 8];

// console.log([...m1,...m2]) 
// console.log([...m1,...m2].sort((a,b)=>a-b))


class ListNode{
    constructor(val){
        this.val = val;
        this.next = null;
    }
}

dummyHead = new ListNode(0);
currentTail = dummyHead;

let l1 = [ 2, 4, 45, 65, 544];
let l2 = [ 10, 20, 30, 40, 50];
let i=0;
let j=0;


while( i<l1.length && j<l2.length){
 
    if(l1[i]<l2[j]){
        currentTail.next  =  new ListNode(l1[i]);
        currentTail = currentTail.next;
        i++; 
    }
    else{
        currentTail.next = new ListNode(l2[j]);
        currentTail = currentTail.next;
        j++;
    }
}

while(i<l1.length){
    currentTail.next = new ListNode(l1[i]);
    currentTail = currentTail.next;
    i++;
}


while(j<l2.length){
    currentTail.next = new ListNode(l2[j]);
    currentTail = currentTail.next;
    j++;
}

while(dummyHead!=null){
    console.log(dummyHead.val);
    dummyHead = dummyHead.next;
}















