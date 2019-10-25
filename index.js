const Epub = require("epub-gen");
const fs = require("fs");

// const title = fs.readFileSync("output/1.txt", "utf-8");
// const content = fs.readFileSync("output/1.html", "utf-8");

// const title2 = fs.readFileSync("output/2.txt", "utf-8");
// const content2 = fs.readFileSync("output/2.html", "utf-8");

const body = [];

for (let i = 1; i <= 352; i++) {
  const title = fs.readFileSync("output/1.txt", "utf-8");
  const content = fs.readFileSync("output/1.html", "utf-8");

  body.push({
    title: fs.readFileSync(`output/${i}.txt`, "utf-8"),
    data: fs.readFileSync(`output/${i}.html`, "utf-8"),
  });
}

const option = {
  title: "术师秘记", // *Required, title of the book.
  author: "雪冷凝霜", // *Required, name of the author.
  publisher: "爱灵异", // optional
  cover: "https://api.kenshu.cc/24/24050/24050s.jpg", // Url or File path, both ok.
  content: body,
};

new Epub(option, "full-book.epub");
