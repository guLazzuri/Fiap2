using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using TDSPG.API.Domain.Entity;

namespace TDSPG.API.Infrastructure.Mappings
{
    public class EstablishmentMapping : IEntityTypeConfiguration<Establishment>
    {
        public void Configure(EntityTypeBuilder<Establishment> builder)
        {
            builder.ToTable("Establishment");

            builder.HasKey("EstablishmentId");

            builder
                .Property(establishment => establishment.Name)
                .HasMaxLength(100)
                .IsRequired();

            builder
                .Property(establishment => establishment.Document)
                .HasMaxLength(30)
                .IsRequired();
        }
    }
}
