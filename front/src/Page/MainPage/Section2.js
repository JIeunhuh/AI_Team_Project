import {Icon} from '../../Component'

export function Section2() {
  return (
    <section className="relative flex w-full h-screen bg-gray-200">
      <div className="w-1/3 h-full"></div>
      <div className="flex items-center justify-center w-2/3 h-full">
        {/* 수치 애니메이션 */}
        <div>
          일일 탄소 배출량 : <span className="">1234</span>
        </div>
      </div>
      <Icon name="arrow_downward" className="absolute text-3xl font-bold left-1/2 bottom-6 animate-bounce" />
    </section>
  )
}
