# Stage 1: Build the React.js application
FROM node:18-alpine

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . .

CMD ["npm","start"]