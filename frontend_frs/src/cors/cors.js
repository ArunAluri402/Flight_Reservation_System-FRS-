const express = require("express");
const app = express();

// Add middleware to set CORS headers
app.use(
  cors({
    origin: "http://localhost:3000",
  })
);

// Your server routes and other middleware here...

// Start the server
app.listen(8080, () => {
  console.log("Server listening on port 8080");
});
