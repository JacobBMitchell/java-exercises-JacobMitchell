const CAPSULE_COUNT = 100;

function init() {
    const capsuleContainer = document.getElementById("capsules");
    let html = "";
    for (let i = 0; i < CAPSULE_COUNT; i++) {
        html += `<div>
            <span id="capsuleLabel${i + 1}" class="badge badge-pill badge-success">Capsule #${i + 1}</span>
            &nbsp;<span id="guest${i + 1}">Unoccupied</span>
        </div>`
    }
    capsuleContainer.innerHTML = html;
}

init();

const guest = document.querySelector("#guest");
const capNum = document.querySelector("#bookingCapsule");
const bookIt = document.querySelector("#bookIt"); //added to html
const msg = document.querySelector("#messages");
const checkout = document.getElementById("checkoutbtn");
const checkoutNum = document.getElementById("checkOutCapsule");

const addCapsule = (e) => {
    e.preventDefault();
    guestName = guest.value;
    let roomNum = capNum.value;
    if (capNum.value > CAPSULE_COUNT || capNum.value < 1){
        msg.style.backgroundColor = " #f2b195"
        msg.innerHTML = "Invalid Number";
        return;
    }
    if (guestName == ""){
        msg.style.backgroundColor = " #f2b195"
        msg.innerHTML = "Name is required";
        return;
    }
    if (document.getElementById("guest"+roomNum).innerHTML != "Unoccupied"){
        msg.style.backgroundColor = " #f2b195"
        msg.innerHTML = "Room is taken";
        return;
    }
    capsule = document.getElementById("capsuleLabel"+roomNum);
    capsule.style.backgroundColor = "red";
    document.getElementById("guest"+roomNum).innerHTML = guestName;
    msg.style.backgroundColor = ""
    msg.innerHTML = "Guest " + guestName +" has been added to room "+roomNum;


}

const leaveCapsule = (e) => {
    e.preventDefault();
    let roomNum = checkoutNum.value;
    if (checkoutNum.value > CAPSULE_COUNT || checkoutNum.value < 1){
        msg.style.backgroundColor = " #f2b195"
        msg.innerHTML = "Invalid Number";
        return;
    }
    if (document.getElementById("guest"+roomNum).innerHTML == "Unoccupied"){
        msg.style.backgroundColor = " #f2b195"
        msg.innerHTML = "Room has no guest!";
        return;
    }
    capsule = document.getElementById("capsuleLabel"+roomNum);
    capsule.style.backgroundColor = "";
    document.getElementById("guest"+roomNum).innerHTML = "Unoccupied";
    msg.style.backgroundColor = "";
    msg.innerHTML = "Guest " + guestName +" has been removed from room "+roomNum;

}

bookIt.addEventListener("click", addCapsule);
checkout.addEventListener("click",leaveCapsule);

