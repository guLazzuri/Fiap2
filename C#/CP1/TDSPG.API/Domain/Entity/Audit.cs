namespace TDSPG.API.Domain.Entity
{
    public class Audit
    {
        public string UserCreated { get; protected set; }

        public DateTime CreatedAt { get; protected set; } = DateTime.Now;

        public virtual string GetInfo()
        {
            return $"Criado por {UserCreated} em {CreatedAt}";
        }
    }
}