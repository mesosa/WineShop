// list with countrynames
var selectBox 	 = ["Choose"];
//var countryNames = ["France","USA","Italy","Spain"];
var countryNames = ["Australia" , "France" , "Germany" , "NewZealand" , "USA"];
// 
// lists with regions 
var regionAustralia =    ["SouthAustraliaRegion" , "SouthAustraliaRegion_2"];
var regionFrance =      ["ChateauRegion" , "ClosRegion" , "RoseRegion"];
var regionGermany =     ["GermanyRegion" , "GermanyRegion_2"];
var regionNewZealand =  ["NewZealandRegion" , "NewZealandRegion_2"];
var regionUSA =         ["ArroyoGrandeRegion" , "CentralTexasRegion" , "EdnaValleyRegion" , "NapaRegion" , "SantaBarbaraRegion" , "SantaCruzMountainsRegion" , "SonomaRegion"];

// lists with wineries from France, USA, Italy, Spain
var wineryAustraliaRegion1  = ["Mountadam"]; // SouthAustraliaRegion 
var wineryAustraliaRegion2  = ["Mountadam"]; // SouthAustraliaRegion_2
var wineryFranceRegion1     = ["ChateauChevalBlanc" , "ChateauLafiteRothschild" , "ChateauMargauxWinery" , "ChateauMorgon"]; // ChateauRegion
var wineryFranceRegion2     = ["ChateauDeMeursault" , "ChateauDYchem" , "ClosDeLaPoussie" , "ClosDeVougeot" ]; // ClosRegion
var wineryFranceRegion3     = ["CortonMontrachet" , "DAnjou" , "SevreEtMaine" , "Taylor"]; // RoseRegion
var wineryGermanyRegion     = ["PulignyMontrachet" , "SchlossRothermel" , "SchlossVolrad"]; // GermanyRegion
var wineryGermanyRegion_2   = ["CongressSprings" , "KalinCellars" , "KathrynKennedy" , "McGuinnesso"]; // GermanyRegion_2
var wineryNewZealandRegion  = ["Longridge" , "Stonleigh"]; // NewZealandRegion
var wineryNewZealandRegion_2 = ["Corbans" , "Selaks" ]; // NewZealandRegion_2
var wineryUSARegion1 = ["SaucelitoCanyon"]; // ArroyoGrandeRegion 
var wineryUSARegion2 = ["StGenevieve" , "Ventana"]; // CentralTexasRegion
var wineryUSARegion3 = ["MountEdenVineyard"]; // EdnaValleyRegion
var wineryUSARegion4 = ["Bancroft" , "Elyse" , "Forman" , "PageMillWinery" , "SeanThackrey" , "WhitehallLane"]; // NapaRegion
var wineryUSARegion5 = ["Foxen" , "LaneTanner" ]; // SantaBarbaraRegion
var wineryUSARegion6 = ["SantaCruzMountainVineyard"]; // SantaCruzMountainsRegion
var wineryUSARegion7 = ["Cotturi" , "GaryFarrell" , "Marietta" , "PeterMccoy"]; // SonomaRegion



function populateSelectListCountries() {
	// create a list of country names based on the above array and populate the select dropdown
	var allCountryNames, allCountriesSelectlist;
	allCountryNames		= selectBox.concat(countryNames);
	return makeSelectList(allCountryNames,"wineCountries");
}

function poplulateSelectListsRegions() {
        // regionAustalia  regionFrance  regionGermany  regionNewZealand  regionUSA   
	var allRegionNames, allRegionSelectlist;
	allRegionNames		= selectBox.concat(regionAustralia).concat(regionFrance).concat(regionGermany).concat(regionNewZealand).concat(regionUSA); 
	return makeSelectList(allRegionNames,"wineRegions");
}

function populateSelectListsWineries() {
	var allWineries, allWineriesAustralia, allWineriesFrance, allWineriesGermany, allWineriesNewZealand, allWineriesUSA, allWineriesSelectlist; //, allWineriesItaly, allWineriesSpain, ;
	allWineriesAustralia    = wineryAustraliaRegion1.concat(wineryAustraliaRegion2);
        allWineriesFrance 	= wineryFranceRegion1.concat(wineryFranceRegion2).concat(wineryFranceRegion3);
        allWineriesGermany      = wineryGermanyRegion.concat(wineryGermanyRegion_2);
        allWineriesNewZealand   = wineryNewZealandRegion.concat(wineryNewZealandRegion_2);
        allWineriesUSA 		= wineryUSARegion1.concat(wineryUSARegion2).concat(wineryUSARegion3).concat(wineryUSARegion4).concat(wineryUSARegion5).concat(wineryUSARegion6).concat(wineryUSARegion7);
	allWineries = selectBox.concat(allWineriesAustralia).concat(allWineriesFrance).concat(allWineriesGermany).concat(allWineriesNewZealand).concat(allWineriesUSA); //.concat(allWineriesItaly).concat(allWineriesSpain);
	return makeSelectList(allWineries,"wineWineries");
}

function populateSelectLists() {
	// populate the select dropdown lists.
	populateSelectListCountries();
	poplulateSelectListsRegions();
	populateSelectListsWineries();	
}

function popCountries(cName) {
    allCountryNames	= selectBox.concat(countryNames);
    // remove the country cName
    var i = allCountryNames.indexOf(cName);
    if(i != -1) {
        allCountryNames.splice(i, 1);
    }

    // and put it on top of the list
    allC = cName + "," + allCountryNames;
    allC = allC.split(",");

    makeSelectList(allC,"wineCountries");
}

function popRegions(regionsName,regionList) {
    //alert(regionsName + " " + regionList);
    allRegionNames	= selectBox.concat(regionList);

    // remove the country cName
    var i = allRegionNames.indexOf(regionsName);
    if(i != -1) {
            allRegionNames.splice(i, 1);
    }

    // and put it on top of the list
    allR = regionsName + "," + allRegionNames;
    allR = allR.split(",");

    makeSelectList(allR,"wineRegions");
}



function makeSelectList(arrayName,elementID) {
    // takes the arrayName and elementID and create a new select list
    var selList;

    for(var i=0;i<arrayName.length;i++)
            selList += "<option value=" + arrayName[i].replace(/\s+/g, '') + ">" + arrayName[i] + "</option>";

    document.getElementById(elementID).innerHTML = selList;
}



function getUserID() {
    // setting user ID using javascript to populate the hidden value (theUserID) in the form and in "p userIDtext" in the navigation
    // some of this might have to go... after we connect the pieces.
    var date = new Date(); 
    var userID = date.getTime();
    var theID = document.getElementById("theUserID").value;

    if (theID == "") {
            document.getElementById("userIDtext").innerHTML = userID;
            document.getElementById("theUserID").value = userID;
    } else {
            document.getElementById("userIDtext").innerHTML = theID;
            document.getElementById("theUserID").value = theID;
    }
}

function setUserID() {
    // resetting of the userID - if we need to make a new user.
    // getting form hidden value: http://www.mkyong.com/javascript/how-to-get-hidden-field-value-in-javascript/

    var date = new Date();
    var userID = date.getTime();

    document.getElementById("userIDtext").innerHTML = userID;
    document.getElementById("theUserID").value = userID;  
}




function testingInstanceCountry(objValue,countryName,regionName,wineryRegionList) {
    
    if(objValue == countryName.replace(/\s+/g, '')) { // Australia 
        regionBox = regionName.join(",");
        wineryBox = wineryRegionList;
    }
}

function testingInstanceRegion(objValue,region,wineryRegion,country) {
    if(objValue == region.replace(/\s+/g, '') ) {
        regionBox = wineryRegion;
        popCountries(country);
    }
}

function testingInstanceWinery(objValue,equalInstance,region,country,regionList) {
    if(objValue == equalInstance.replace(/\s+/g, '')) { 
        popCountries(country);
        popRegions(region,regionList);
        wineryBox = equalInstance;
    }
}


function changeRegionDropdown() {
    // populate the select list dynamically.
    // http://codingforums.com/javascript-programming/107194-using-javascript-dynamically-populate-select-lists.html

    var regionBox, wineryBox, regionSelectlist, winerySelectlist, regionObjValue, wineryObjValue, countryBox, countrySelectlist;
    var countryObj = document.all.wineCountry;
    var wineryObj = document.all.wineRegion;
    regionObjValue = countryObj.options[countryObj.selectedIndex].value;
    wineryObjValue = wineryObj.options[wineryObj.selectedIndex].value;

    if(regionObjValue){
                
        
        if(regionObjValue == countryNames[0].replace(/\s+/g, '')) { // Australia
                regionBox = regionAustralia.join(",");
                wineryBox = wineryAustraliaRegion1.concat(wineryAustraliaRegion2);
        }
        
        if(regionObjValue == countryNames[1].replace(/\s+/g, '')) {  // France
                regionBox = regionFrance.join(",");
                wineryBox = wineryFranceRegion1.concat(wineryFranceRegion2).concat(wineryFranceRegion3);
        }
        
        if(regionObjValue == countryNames[2].replace(/\s+/g, '')) {  // Germany
                regionBox = regionGermany.join(",");
                wineryBox = wineryGermanyRegion.concat(wineryGermanyRegion_2);
        }
        
        if(regionObjValue == countryNames[3].replace(/\s+/g, '')) {  // New Zealand  
                regionBox = regionNewZealand.join(",");
                wineryBox = wineryNewZealandRegion.concat(wineryNewZealandRegion_2);
        }
        
        if(regionObjValue == countryNames[4].replace(/\s+/g, '')) {  // USA  
                regionBox = regionUSA.join(",");
                wineryBox = wineryUSARegion1.concat(wineryUSARegion2).concat(wineryUSARegion3);
        }

        if(regionObjValue == "Choose") {
                populateSelectLists();
        }

        regionBox = regionBox.split(",");

        makeSelectList(regionBox,"wineRegions");
        makeSelectList(wineryBox,"wineWineries");

    }
}

function changeWineryDropdown(){
    var wineryBox, winerySelectlist, wineryObjValue, countryBox, CountrySelectlist;
    var regionObj = document.all.wineRegion;
    wineryObjValue = regionObj.options[regionObj.selectedIndex].value;

    if(wineryObjValue){
        // Australian regions
        testingInstanceRegion(wineryObjValue,regionAustralia[0],wineryAustraliaRegion1,countryNames[0]);
        testingInstanceRegion(wineryObjValue,regionAustralia[1],wineryAustraliaRegion2,countryNames[0]);

        testingInstanceRegion(wineryObjValue,regionFrance[0],wineryFranceRegion1,countryNames[1]);
        testingInstanceRegion(wineryObjValue,regionFrance[1],wineryFranceRegion2,countryNames[1]);
        testingInstanceRegion(wineryObjValue,regionFrance[2],wineryFranceRegion3,countryNames[1]);

        testingInstanceRegion(wineryObjValue,regionGermany[0],wineryGermanyRegion,countryNames[2]);
        testingInstanceRegion(wineryObjValue,regionGermany[1],wineryGermanyRegion_2,countryNames[2]);

        testingInstanceRegion(wineryObjValue,regionNewZealand[0],wineryNewZealandRegion,countryNames[3]);
        testingInstanceRegion(wineryObjValue,regionNewZealand[1],wineryNewZealandRegion_2,countryNames[3]);

        testingInstanceRegion(wineryObjValue,regionUSA[0],wineryUSARegion1,countryNames[4]);
        testingInstanceRegion(wineryObjValue,regionUSA[1],wineryUSARegion2,countryNames[4]);
        testingInstanceRegion(wineryObjValue,regionUSA[2],wineryUSARegion3,countryNames[4]);
        testingInstanceRegion(wineryObjValue,regionUSA[3],wineryUSARegion4,countryNames[4]);
        testingInstanceRegion(wineryObjValue,regionUSA[4],wineryUSARegion5,countryNames[4]);
        testingInstanceRegion(wineryObjValue,regionUSA[5],wineryUSARegion6,countryNames[4]);
        testingInstanceRegion(wineryObjValue,regionUSA[6],wineryUSARegion7,countryNames[4]);
        
        if(wineryObjValue == "Choose") {
            populateSelectLists();
	}
        
        makeSelectList(regionBox,"wineWineries");
		
    }
}

function changeWineryCountryRegionDropdown() {
    // populate the select list dynamically.
    // http://codingforums.com/javascript-programming/107194-using-javascript-dynamically-populate-select-lists.html
    var regionBox, wineryBox;
    var wineryObj = document.all.wineWinery;
    wineryObjValue  = wineryObj.options[wineryObj.selectedIndex].value;

    if(wineryObjValue){
        // Australia
        testingInstanceWinery(wineryObjValue,wineryAustraliaRegion1[0],regionAustralia[0],countryNames[0],regionAustralia);
        testingInstanceWinery(wineryObjValue,wineryAustraliaRegion2[0],regionAustralia[1],countryNames[0],regionAustralia);

        // France
        testingInstanceWinery(wineryObjValue,wineryFranceRegion1[0],regionFrance[0],countryNames[1],regionFrance);
        testingInstanceWinery(wineryObjValue,wineryFranceRegion1[1],regionFrance[0],countryNames[1],regionFrance);
        testingInstanceWinery(wineryObjValue,wineryFranceRegion1[2],regionFrance[0],countryNames[1],regionFrance);
        testingInstanceWinery(wineryObjValue,wineryFranceRegion1[3],regionFrance[0],countryNames[1],regionFrance);

        testingInstanceWinery(wineryObjValue,wineryFranceRegion2[0],regionFrance[1],countryNames[1],regionFrance);
        testingInstanceWinery(wineryObjValue,wineryFranceRegion2[1],regionFrance[1],countryNames[1],regionFrance);
        testingInstanceWinery(wineryObjValue,wineryFranceRegion2[2],regionFrance[1],countryNames[1],regionFrance);
        testingInstanceWinery(wineryObjValue,wineryFranceRegion2[3],regionFrance[1],countryNames[1],regionFrance);

        testingInstanceWinery(wineryObjValue,wineryFranceRegion3[0],regionFrance[2],countryNames[1],regionFrance);
        testingInstanceWinery(wineryObjValue,wineryFranceRegion3[1],regionFrance[2],countryNames[1],regionFrance);
        testingInstanceWinery(wineryObjValue,wineryFranceRegion3[2],regionFrance[2],countryNames[1],regionFrance);
        testingInstanceWinery(wineryObjValue,wineryFranceRegion3[3],regionFrance[2],countryNames[1],regionFrance);

        // Germany
        testingInstanceWinery(wineryObjValue,wineryGermanyRegion[0],regionGermany[0],countryNames[2],regionGermany);
        testingInstanceWinery(wineryObjValue,wineryGermanyRegion[1],regionGermany[0],countryNames[2],regionGermany);
        testingInstanceWinery(wineryObjValue,wineryGermanyRegion[2],regionGermany[0],countryNames[2],regionGermany);

        testingInstanceWinery(wineryObjValue,wineryGermanyRegion_2[0],regionGermany[1],countryNames[2],regionGermany);
        testingInstanceWinery(wineryObjValue,wineryGermanyRegion_2[1],regionGermany[1],countryNames[2],regionGermany);
        testingInstanceWinery(wineryObjValue,wineryGermanyRegion_2[2],regionGermany[1],countryNames[2],regionGermany);
        testingInstanceWinery(wineryObjValue,wineryGermanyRegion_2[3],regionGermany[1],countryNames[2],regionGermany);

        // New Zealand
        testingInstanceWinery(wineryObjValue,wineryNewZealandRegion[0],regionNewZealand[0],countryNames[3],regionNewZealand);
        testingInstanceWinery(wineryObjValue,wineryNewZealandRegion[1],regionNewZealand[0],countryNames[3],regionNewZealand);

        testingInstanceWinery(wineryObjValue,wineryNewZealandRegion_2[0],regionNewZealand[1],countryNames[3],regionNewZealand);
        testingInstanceWinery(wineryObjValue,wineryNewZealandRegion_2[1],regionNewZealand[1],countryNames[3],regionNewZealand);

        // USA
        testingInstanceWinery(wineryObjValue,wineryUSARegion1[0],regionUSA[0],countryNames[4],regionUSA);

        testingInstanceWinery(wineryObjValue,wineryUSARegion2[0],regionUSA[1],countryNames[4],regionUSA);
        testingInstanceWinery(wineryObjValue,wineryUSARegion2[1],regionUSA[1],countryNames[4],regionUSA);

        testingInstanceWinery(wineryObjValue,wineryUSARegion3[0],regionUSA[2],countryNames[4],regionUSA);

        testingInstanceWinery(wineryObjValue,wineryUSARegion4[0],regionUSA[3],countryNames[4],regionUSA);
        testingInstanceWinery(wineryObjValue,wineryUSARegion4[1],regionUSA[3],countryNames[4],regionUSA);
        testingInstanceWinery(wineryObjValue,wineryUSARegion4[2],regionUSA[3],countryNames[4],regionUSA);
        testingInstanceWinery(wineryObjValue,wineryUSARegion4[3],regionUSA[3],countryNames[4],regionUSA);
        testingInstanceWinery(wineryObjValue,wineryUSARegion4[4],regionUSA[3],countryNames[4],regionUSA);
        testingInstanceWinery(wineryObjValue,wineryUSARegion4[5],regionUSA[3],countryNames[4],regionUSA);

        testingInstanceWinery(wineryObjValue,wineryUSARegion5[0],regionUSA[4],countryNames[4],regionUSA);
        testingInstanceWinery(wineryObjValue,wineryUSARegion5[1],regionUSA[4],countryNames[4],regionUSA);

        testingInstanceWinery(wineryObjValue,wineryUSARegion6[0],regionUSA[5],countryNames[4],regionUSA);

        testingInstanceWinery(wineryObjValue,wineryUSARegion7[0],regionUSA[6],countryNames[4],regionUSA);
        testingInstanceWinery(wineryObjValue,wineryUSARegion7[1],regionUSA[6],countryNames[4],regionUSA);
        testingInstanceWinery(wineryObjValue,wineryUSARegion7[2],regionUSA[6],countryNames[4],regionUSA);
        testingInstanceWinery(wineryObjValue,wineryUSARegion7[3],regionUSA[6],countryNames[4],regionUSA);
        
        if(wineryObjValue == "Choose") {
            populateSelectLists();
	}

        regionBox = regionBox.split(",");
        wineryBox = wineryBox.split(",");

        makeSelectList(regionBox,"wineRegions");
        makeSelectList(wineryBox,"wineWineries");

    }
}


function testalert() {
	alert("working");
}



// populate the select lists
window.addEventListener("load", populateSelectLists);
window.addEventListener("load", getUserID);

//window.addEventListener("load", testalert);
window.addEventListener("load", function() {
        var buttons = document.getElementById("reBut");
        buttons.addEventListener("click", setUserID);
        var countBut = document.getElementById("wineCountries");
        countBut.addEventListener("change", changeRegionDropdown);
        var regiBut = document.getElementById("wineRegions");
        regiBut.addEventListener("change", changeWineryDropdown);
        var winBut = document.getElementById("wineWineries");
        winBut.addEventListener("change", changeWineryCountryRegionDropdown);
    }    
);






