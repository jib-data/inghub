FROM node:20-alpine

WORKDIR /inGHubfrontend

COPY package.json /inGHubfrontend

RUN yarn install

COPY . .

EXPOSE 3000

CMD ["yarn", "start"]