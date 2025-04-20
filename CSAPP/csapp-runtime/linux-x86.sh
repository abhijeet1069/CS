#!/bin/bash
IMAGE_NAME="csapp-x86"
DOCKERFILE_PATH="./"
WORKSPACE="$(cd ../csapp-workspace && pwd)"

# Create workspace folder if it doesn't exist
mkdir -p "$WORKSPACE"

# Check if Docker image exists
if [[ "$(docker images -q $IMAGE_NAME 2> /dev/null)" == "" ]]; then
    echo "[+] Image '$IMAGE_NAME' not found. Building it now..."
    
    # Check if Dockerfile directory exists
    if [ ! -f "$DOCKERFILE_PATH/Dockerfile" ]; then
        echo "[-] Dockerfile not found at $DOCKERFILE_PATH. Please make sure it exists."
        exit 1
    fi

    docker build -t $IMAGE_NAME "$DOCKERFILE_PATH" || { echo "[-] Docker build failed."; exit 1; }
fi

# Run the container
docker run --platform=linux/amd64 -it \
  -v "$WORKSPACE":/workspace \
  --name csapp-container \
  --rm \
  $IMAGE_NAME