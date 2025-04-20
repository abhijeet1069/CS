# CS:APP-friendly x86_64 Ubuntu container
FROM --platform=linux/amd64 ubuntu:20.04

ENV DEBIAN_FRONTEND=noninteractive

# Install GNU development tools
RUN apt update && apt install -y \
    build-essential \
    gdb \
    make \
    vim \
    git \
    curl \
    man \
    nasm \
    net-tools \
    iputils-ping \
    less \
    unzip \
    valgrind \
    && rm -rf /var/lib/apt/lists/*

# Set the default working directory
WORKDIR /workspace

# Start bash
CMD ["/bin/bash"]