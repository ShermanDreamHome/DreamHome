import {FILE_STACK_API_KEY} from "./config";

const client = filestack.init(FILE_STACK_API_KEY);
client.picker().open();