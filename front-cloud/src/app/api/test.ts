"use server"

async function createTasksList() {
    const response = await fetch('http://springboot-demo:8088/aws/task');
    const data = await response.json();
    return data;
}

export default createTasksList;