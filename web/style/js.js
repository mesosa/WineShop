// list with countrynames
var selectBox 	 = ["Choose"];
var countryNames = ["France","USA","Italy","Spain"];

// lists with regions 
var regionFrance = ["Fregion 1", "Fregion 2", "Fregion 3"];
var regionUSA 	 = ["Uregion 1", "Uregion 2", "Uregion 3"];
var regionItaly  = ["Iregion 1", "Iregion 2", "Iregion 3"];
var regionSpain  = ["Sregion 1", "Sregion 2", "Sregion 3"];

// lists with wineries from France, USA, Italy, Spain
var wineryFranceRegion1 = ["Fwinery 1 - R1" , "Fwinery 2 - R1" , "Fwinery 3 - R1"];
var wineryFranceRegion2 = ["Fwinery 1 - R2" , "Fwinery 2 - R2" , "Fwinery 3 - R2"];
var wineryFranceRegion3 = ["Fwinery 1 - R3" , "Fwinery 2 - R3" , "Fwinery 3 - R3"];
var wineryUSARegion1 = ["Uwinery 1 - R1" , "Uwinery 2 - R1" , "Uwinery 3 - R1"];
var wineryUSARegion2 = ["Uwinery 1 - R2" , "Uwinery 2 - R2" , "Uwinery 3 - R2"];
var wineryUSARegion3 = ["Uwinery 1 - R3" , "Uwinery 2 - R3" , "Uwinery 3 - R3"];
var wineryItalyRegion1 = ["Iwinery 1 - R1" , "Iwinery 2 - R1" , "Iwinery 3 - R1"];
var wineryItalyRegion2 = ["Iwinery 1 - R2" , "Iwinery 2 - R2" , "Iwinery 3 - R2"];
var wineryItalyRegion3 = ["Iwinery 1 - R3" , "Iwinery 2 - R3" , "Iwinery 3 - R3"];
var winerySpainRegion1 = ["Swinery 1 - R1" , "Swinery 2 - R1" , "Swinery 3 - R1"];
var winerySpainRegion2 = ["Swinery 1 - R2" , "Swinery 2 - R2" , "Swinery 3 - R2"];
var winerySpainRegion3 = ["Swinery 1 - R3" , "Swinery 2 - R3" , "Swinery 3 - R3"];


function populateSelectLists() {
	
	populateSelectListCountries();
	poplulateSelectListsRegions();
	populateSelectListsWineries();	

}


function populateSelectListCountries() {
	
	var allCountryNames, allCountriesSelectlist;
	allCountryNames		= selectBox.concat(countryNames);
	
	return makeSelectList(allCountryNames,"wineCountries");

}


function poplulateSelectListsRegions() {

	var allRegionNames, allRegionSelectlist;
	allRegionNames		= selectBox.concat(regionFrance).concat(regionUSA).concat(regionItaly).concat(regionSpain);	

	return makeSelectList(allRegionNames,"wineRegions");

}


function populateSelectListsWineries() {

	var allWineries, allWineriesFrance, allWineriesUSA, allWineriesItaly, allWineriesSpain, allWineriesSelectlist;
	allWineriesFrance 	= wineryFranceRegion1.concat(wineryFranceRegion2).concat(wineryFranceRegion3);
	allWineriesUSA 		= wineryUSARegion1.concat(wineryUSARegion2).concat(wineryUSARegion3);
	allWineriesItaly 	= wineryItalyRegion1.concat(wineryItalyRegion2).concat(wineryItalyRegion3);
	allWineriesSpain 	= winerySpainRegion1.concat(winerySpainRegion2).concat(winerySpainRegion3);
	allWineries = selectBox.concat(allWineriesFrance).concat(allWineriesUSA).concat(allWineriesItaly).concat(allWineriesSpain);

	return makeSelectList(allWineries,"wineWineries");

}


function popRegions(cName) {
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





function changeRegionDropdown() {
	// populate the select list dynamically.
	// http://codingforums.com/javascript-programming/107194-using-javascript-dynamically-populate-select-lists.html

	var regionBox, wineryBox, regionSelectlist, winerySelectlist, regionObjValue, wineryObjValue, countryBox, countrySelectlist;
	var regionObj = document.all.wineCountry;
	var wineryObj = document.all.wineRegion;
	regionObjValue = regionObj.options[regionObj.selectedIndex].value;
	wineryObjValue = wineryObj.options[wineryObj.selectedIndex].value;

	if(regionObjValue){
		if(regionObjValue == countryNames[0].replace(/\s+/g, '')) {
			regionBox = regionFrance.join(",");
			wineryBox = wineryFranceRegion1.concat(wineryFranceRegion2).concat(wineryFranceRegion3);
		}
		
		if(regionObjValue == countryNames[1].replace(/\s+/g, '')) {
			regionBox = regionUSA.join(",");
			wineryBox = wineryUSARegion1.concat(wineryUSARegion2).concat(wineryUSARegion3);
		}
		
		if(regionObjValue == countryNames[2].replace(/\s+/g, '')) {
			regionBox = regionItaly.join(",");
			wineryBox = wineryItalyRegion1.concat(wineryItalyRegion2).concat(wineryItalyRegion3);
		}
		
		if(regionObjValue == countryNames[3].replace(/\s+/g, '')) {
			regionBox = regionSpain.join(",");
			wineryBox = winerySpainRegion1.concat(winerySpainRegion2).concat(winerySpainRegion3);
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
	var wineryObj = document.all.wineRegion;
	wineryObjValue = wineryObj.options[wineryObj.selectedIndex].value;

	if(wineryObjValue){
		// French regions
		if(wineryObjValue == regionFrance[0].replace(/\s+/g, '') ) {
			wineryBox = wineryFranceRegion1;
			popRegions(countryNames[0]);
		}
		if(wineryObjValue == regionFrance[1].replace(/\s+/g, '') ) {
			wineryBox = wineryFranceRegion2;
			popRegions(countryNames[0]);
		}
		if(wineryObjValue == regionFrance[2].replace(/\s+/g, '') ) {
			wineryBox = wineryFranceRegion3;
			popRegions(countryNames[0]);
		}
		
		// USA regions
		if(wineryObjValue == regionUSA[0].replace(/\s+/g, '') ) {
			wineryBox = wineryUSARegion1;
			popRegions(countryNames[1]);
		}
		if(wineryObjValue == regionUSA[1].replace(/\s+/g, '') ) {
			wineryBox = wineryUSARegion2;
			popRegions(countryNames[1]);
		}
		if(wineryObjValue == regionUSA[2].replace(/\s+/g, '') ) {
			wineryBox = wineryUSARegion3;
			popRegions(countryNames[1]);
		}
		
		// Italian regions
		if(wineryObjValue == regionItaly[0].replace(/\s+/g, '') ) {
			wineryBox = wineryItalyRegion1;
			popRegions(countryNames[2]);
		}
		if(wineryObjValue == regionItaly[1].replace(/\s+/g, '') ) {
			wineryBox = wineryItalyRegion2;
			popRegions(countryNames[2]);
		}
		if(wineryObjValue == regionItaly[2].replace(/\s+/g, '') ) {
			wineryBox = wineryItalyRegion3;
			popRegions(countryNames[2]);
		}
		
		// Spanish regions
		if(wineryObjValue == regionSpain[0].replace(/\s+/g, '') ) {
			wineryBox = winerySpainRegion1;
			popRegions(countryNames[3]);
		}
		if(wineryObjValue == regionSpain[1].replace(/\s+/g, '') ) {
			wineryBox = winerySpainRegion2;
			popRegions(countryNames[3]);
		}
		if(wineryObjValue == regionSpain[2].replace(/\s+/g, '') ) {
			wineryBox = winerySpainRegion3;
			popRegions(countryNames[3]);
		}
		
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
    }    
);






