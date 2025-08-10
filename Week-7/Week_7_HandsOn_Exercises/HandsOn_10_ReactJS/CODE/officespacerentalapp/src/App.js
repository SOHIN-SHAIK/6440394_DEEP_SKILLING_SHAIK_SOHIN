import React from "react";
import "./App.css";

function App() {
  const element = "Office Space";
 const sr = "https://png.pngtree.com/background/20230604/original/pngtree-modern-corporate-business-office-background-wallpaper-picture-image_2873050.jpg";

  const jsxatt = (
    <img src={sr} width="25%" height="25%" alt="Office Space" />
  );

  const ItemName = { Name: "DBS", Rent: 50000, Address: "Chennai" };

  let colors = [];
  if (ItemName.Rent <= 60000) {
    colors.push("textRed");
  } else {
    colors.push("textGreen");
  }

  return (
    <div className="App">
      <h1><b>{element} , at Affordable Range</b></h1>
      {jsxatt}
      <h1><b>Name: {ItemName.Name}</b></h1>
      <h3 className={colors.join(" ")}><b>Rent: Rs. {ItemName.Rent}</b></h3>
      <h3><b>Address: {ItemName.Address}</b></h3>
    </div>
  );
}

export default App;
