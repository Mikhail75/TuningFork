package com.mglizerin.tuningfork.sound.interfaces

/**
 * Содержит набор звуков, необходимых для воспроизведения [семплов][ISample]
 */
interface ISoundBank {
    /**
     * Добавляет звук в банк
     *
     * @param pitch Параметры [высоты звука][IPitch]
     * @param resourceId Идентификатор ресурса, соответствующего заданным параметрам звука
     */
    fun addSound(pitch: IPitch, resourceId: Int)

    /**
     * @return Идентфикатор ресурса, соответствующего заданным параметрам [высоты звука][IPitch]
     */
    fun getResource(pitch: IPitch): Int?

    /**
     * Последовательно проходит по коллекции звуков, входящих в банк.
     * Для каждого звука один раз вызывает функцию apply, передавая в неё
     * параметры [высоты звука][IPitch] и соответствующий идентификатор реруса
     */
    fun forEachSound(apply: (IPitch, Int) -> Unit)
}