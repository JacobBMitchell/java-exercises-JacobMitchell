# This line is a comment.
# Empty lines are allowed to chunk our thinking.

# FROM specifies a base image. It's the image starting point.
FROM alpine:3.15

# RUN executes a shell command. It's part of image creation, not container creation.
RUN echo 'This happens during image construction.'

# WORKDIR sets a directory as the working directory
# All instructions from here on will execute from the context of this directory.
# If the directory doesn't exist. It creates it.
WORKDIR /home/app

# CMD specifies the command or executable to run when
# the container first runs.
CMD [ "echo", "This happens the first time a container is run."]