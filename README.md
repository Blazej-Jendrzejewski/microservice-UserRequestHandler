# Microservice-UserRequestHandler

## Description

The `Microservice-UserRequestHandler` acts as a handler for user requests. It fetches user-specific data from GitHub repositories using the `Microservice-GithubAPI`.

## Key Components

### Models:
- `RepoInfo.java`
- `RepoDTO.java`
- `CustomErrorResponse.java`
- `BranchInfoDTO.java`

### Service:
- `UserRequestService.java`

  Contains the logic to process user requests and communicate with `Microservice-GithubAPI`.

### Controller:
- `UserRequestController.java`

  Handles incoming user requests and processes responses.

## Setup and Usage

1. Clone the repository.
2. Navigate to the microservice's directory.
3. Adjust configurations if necessary (especially url address for Microservice-GithubAPI).
4. Start the service.
