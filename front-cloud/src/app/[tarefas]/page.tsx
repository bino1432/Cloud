'use client'
import Header from "@/components/Header";
import { getAllFiles, postFile } from "../api/file/fileService";
import { useParams } from "next/navigation";
import { useEffect, useState } from "react";

export default function teste() {

    const id = useParams<{ tarefas: string }>()

    const [listImage, setListaImage] = useState<string[]>([])

    const postImage = async (form: FormData) => {
        if (form.get("file")) {
            console.log(id.tarefas)
            await postFile(id.tarefas, form)
        }
    }

    const getAllImages = async () => {
        await getAllFiles(id.tarefas).then((response) => {
            console.log(response)
            setListaImage(response)
        })
        
    }

    useEffect(() => {
        getAllImages()
    }, []);

    return (
        <div>
            <Header />

            <form action={(form) => postImage(form)}
                className="flex place-content-center gap-3 my-10">
                <input
                    name="file"
                    className="bg-green-300 h-10 border-2 border-green-600 rounded-lg"
                    type="file" />
                <input
                    className="content-center text-neutral-100 text-xl border-2 border-green-800 
                rounded-xl bg-green-700 ease-in-out duration-300 hover:bg-green-800 h-10 w-24"
                    type="submit" />
            </form>
            <div>
                {listImage.map((todo, key) => {
                    return <img alt="imageAWS" src={todo} key={key}/>
                })}

                
            </div>
        </div>
    );
}