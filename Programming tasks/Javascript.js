function Vehicle(){
    this.numWheels = 4;
    this.color = "yellow";
    this.blowHorn = function (){
        return 'Beep!';
    }
}

function Taxi(badgeNumber){
    this.badgeNumber = badgeNumber;
}

Taxi.prototype = new Vehicle();

var fleet = [];

for (var i = 0; i < 5; i++) {
    fleet[i] = new Taxi(i);
}
for (var i = 0; i < fleet.length; i++) {
    console.log("Taxi with badge number " + fleet[i].badgeNumber +
        " is " + fleet[i].color);
}

Taxi.prototype.color = "White";


for (var i = 0; i < fleet.length; i++) {
    console.log("Taxi with badge number " + fleet[i].badgeNumber +
        " is " + fleet[i].color);
    console.log(fleet[i].blowHorn());
}