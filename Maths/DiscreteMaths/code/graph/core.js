const textarea = document.getElementById("code");
const canvas = document.getElementById("canvas");
const ctx = canvas.getContext("2d");

function resizeCanvas() {
    const dpr = window.devicePixelRatio || 1;
    const container = document.getElementById("canvas-container");
    const rect = container.getBoundingClientRect();

    canvas.width = rect.width * dpr;
    canvas.height = rect.height * dpr;
    canvas.style.width = rect.width + "px";
    canvas.style.height = rect.height + "px";

    ctx.setTransform(1, 0, 0, 1, 0, 0); // Reset any scaling
    ctx.scale(dpr, dpr); // Scale drawing operations
}

function draw() {
    resizeCanvas(); // Ensure canvas is sized correctly before drawing
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    try {
        eval(textarea.value);
    } catch (e) {
        console.error("Drawing Error:", e.message);
    }
}

textarea.addEventListener("input", draw);
window.addEventListener("load", draw);
window.addEventListener("resize", draw);