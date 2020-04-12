var a =[false,false,false,false];
var city_name =["city_1","city_2","city_3","city_4"];
var n = 0;
var us = document.getElementById("u_name").value;
console.log(us)
//this is printing blank
document.getElementById("user").innerHTML = us;
var permit = false;

// function fun(n) {
//     let str="";
//     for(var i=0;i<city_name.length;i++) {
//         if(n === i) {
//             a[i] = true;
//         }
//         else 
//            a[i] = false;
//     }
//     for(var i=0;i<city_name.length;i++){
//         if(a[i])
//         str = city_name[i].fontcolor("Green");
//         else
//         str = city_name[i].fontcolor("Red");

//     document.getElementById("root").innerHTML += str;
//     }
//     console.log(document.getElementById("root").innerText);
//     //yha pr old name hta kr new name print ni ho rhe h add up ho rhe h and ye greeen bhi sath m nhi ho rhe h psarticular city name hi ho rhi h   
// }

function fun(n) {
    let str = "";
    for(var i = 0;i < city_name.length;i++) {
        if(i<=n)
        str = city_name[i].fontcolor("Green");
        else
        str = city_name[i].fontcolor("Red");

        document.getElementById("root").innerHTML += str;
    }
    console.log(document.getElementById("root").innerText);
    //yha pr old name hta kr new name print ni ho rhe h add up ho rhe h and ye greeen bhi sath m nhi ho rhe h psarticular city name hi ho rhi h   
}

function fun1() {
    if(permit) {
   var cn = document.getElementById("cities").value; 
   console.log(cn);
   for(var i=0;i<city_name.length;i++) {
        if(cn === city_name[i])
        n=i;
        console.log(n);
   }
   fun(n);
    }
    else {
        console.log("Invalid");
    }
}
// const data;
// async function funny() {
//     const response = await fetch("URL.....");
//     data = response.json();
//     bigfun(data,0);
// }
// function bigfun(data,index) {
//         var usr = document.getElementById("u_name").value; 
        
//         var pss = document.getElementById("pass").value;
        
//         if((usr === data[index])&&(pass === data[index]))
//         document.getElementById("page").innerHTML = "Confirmed...!!";
//         else
//         document.getElementById("page").innerHTML = "Failed....!!";
// }
//function check() {
//    var usr = document.getElementById("u_name").value;
//    console.log(usr+"111");
//        var pss = document.getElementById("pass").value;
//        console.log(pss+"222");
//        if((usr === "user")&&(pss === "000")) {
//        document.getElementById("page").innerHTML = "Confirmed...!!";
//        permit = true;
//        }
//        else {
//        document.getElementById("page").innerHTML = "Failed....!!";
//        permit = false;
//        document.getElementById("head").innerHTML = "INVALID";
//        document.getElementById("cities").style.backgroundColor = "black";
//        }
//}