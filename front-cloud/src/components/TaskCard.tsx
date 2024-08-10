import Link from "next/link";

interface TaskCardProps {
    id: number,
    nome: string
}

export default function TaskCard({ id, nome }: TaskCardProps){
    return(
        <Link href={`/${id}`} className="bg-green-300 p-3 border-2 border-green-600 rounded-lg">
            <h1>
                {nome}
            </h1>
        </Link>
    );
}